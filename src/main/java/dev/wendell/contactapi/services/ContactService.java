package dev.wendell.contactapi.services;

import dev.wendell.contactapi.dtos.ContactDTO;
import dev.wendell.contactapi.entities.Contact;
import dev.wendell.contactapi.repositories.ContactRepository;
import dev.wendell.contactapi.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ContactService {

    @Value("${app.path.files}")
    private String pathFiles;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public List<ContactDTO> findAll() {
        List<Contact> list = contactRepository.findAllByOrderByNomeAsc();
        List<ContactDTO> listDTO = list.stream().map(obj -> new ContactDTO(obj)).collect(Collectors.toList());
        return listDTO;
    }

    @Transactional(readOnly = true)
    public List<ContactDTO> findAllByStatusIs(boolean status) {
        List<Contact> list = contactRepository.findAllByStatusIs(status);
        List<ContactDTO> listDTO = list.stream().map(obj -> new ContactDTO(obj)).collect(Collectors.toList());
        return listDTO;
    }

    @Transactional(readOnly = true)
    public Page<ContactDTO> findPage(Pageable pageable) {
        Page<Contact> response = contactRepository.findAll(pageable);
        Page<ContactDTO> page = response.map(x-> new ContactDTO(x));
        return page;
    }

    @Transactional(readOnly = true)
    public Contact findById(Long id){
        Optional<Contact> contact = contactRepository.findById(id);
        return contact.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado ID: " + id));
    }

    @Transactional
    public ContactDTO insert(ContactDTO contactDTO) {
        Contact contact = modelMapper.map(contactDTO, Contact.class);
        contactDTO = modelMapper.map(contactRepository.save(contact), ContactDTO.class);
        return contactDTO;
    }

    @Transactional
    public ContactDTO update(ContactDTO contactDTO, Long id) {
        Contact contact = findById(id);
        updateContact(contact, contactDTO);
        return modelMapper.map(contactRepository.save(contact),ContactDTO.class);
    }

    private void updateContact(Contact contact, ContactDTO contactUpdate) {
        contact.setNome(contactUpdate.getNome());
        contact.setRamalInterno(contactUpdate.getRamalInterno());
        contact.setRamalExterno(contactUpdate.getRamalExterno());
        contact.setEmail(contactUpdate.getEmail());
        contact.setCorporativo(contactUpdate.getCorporativo());
        contact.setSetor(contactUpdate.getSetor());
        contact.setImagemUrl(contactUpdate.getImagemUrl());
        contact.setStatus(contactUpdate.isStatus());
    }

    public String uploadFile(MultipartFile file, Long idContact){
        Contact contact = findById(idContact);
        var fileName = UUID.randomUUID() + "." + extensionExtract(file.getOriginalFilename());
        var path = pathFiles + fileName;
        //var path = pathFiles + UUID.randomUUID() + "." + extensionExtract(file.getOriginalFilename());
        //var path = pathFiles + file.getOriginalFilename();
        try{
            Files.copy(file.getInputStream(), Path.of(path), StandardCopyOption.REPLACE_EXISTING);
            //contact.setImagemUrl(pathFiles + file.getOriginalFilename());
            contact.setImagemUrl("/assets/images/" + fileName);
            contactRepository.save(contact);
            return "{\"mensagem\" : \"Arquivo carregado com sucesso!\"}";
        }catch (Exception e) {
            e.printStackTrace();
            return "{\"mensagem\" : \"Problemas na tentativa de salvar arquivo!\"}";
        }
    }

    private String extensionExtract(String originalFilename) {
        int i = originalFilename.lastIndexOf(".");
        return originalFilename.substring(i+1);
    }

    @Transactional
    public void deleteById(Long idContact) {
        Contact contact = findById(idContact);
        contactRepository.deleteById(contact.getId());
    }
}
