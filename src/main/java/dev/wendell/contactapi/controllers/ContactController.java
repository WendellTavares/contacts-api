package dev.wendell.contactapi.controllers;

import dev.wendell.contactapi.dtos.ContactDTO;
import dev.wendell.contactapi.services.ContactService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/contacts")
public class ContactController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ContactService contactService;

    @GetMapping
    public ResponseEntity<List<ContactDTO>> findAll() {
        List<ContactDTO> listDTO = contactService.findAll();
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<ContactDTO>> findAllByStatusIs(@PathVariable boolean status) {
        List<ContactDTO> listDTO = contactService.findAllByStatusIs(status);
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value = "/page")
    public ResponseEntity<Page<ContactDTO>> findAll(Pageable pageable) {
        Page<ContactDTO> page = contactService.findPage(pageable);
        return ResponseEntity.ok().body(page);
    }

    @GetMapping("/{idContact}")
    public ResponseEntity<ContactDTO> findById(@PathVariable Long idContact) {
       ContactDTO contactDTO = modelMapper.map(contactService.findById(idContact), ContactDTO.class);
       return ResponseEntity.ok().body(contactDTO);
    }

    @PostMapping
    public ResponseEntity<ContactDTO> insert(@Valid @RequestBody ContactDTO contactDTO) {
        contactDTO = contactService.insert(contactDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(contactDTO.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{idContact}")
    public ResponseEntity<Void> update(@Valid @RequestBody ContactDTO contactDTO, @PathVariable Long idContact) {
        contactService.update(contactDTO, idContact);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/{idContact}/uploadFile", produces = "application/json")
    public ResponseEntity<String> uploadFile (@RequestParam("file")MultipartFile file, @PathVariable Long idContact) {
        String status = contactService.uploadFile(file, idContact);
        return ResponseEntity.ok().body(status);
    }

    @DeleteMapping("/{idContact}")
    public ResponseEntity<Void> delete(@PathVariable Long idContact) {
        contactService.deleteById(idContact);
        return ResponseEntity.ok().build();
    }

}
