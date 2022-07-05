package dev.wendell.contactapi.services;

import dev.wendell.contactapi.entities.Contact;
import dev.wendell.contactapi.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private ContactRepository contactRepository;

    private final String image = "";

    public void instantiateTestDatabase() throws ParseException {
        /*

        Contact contact1 =new Contact(null,"Adriana Helena de Souza Dia","30008","1134440480","adriana.dias@polishop.com.br","","Gestão de Resultados",image,true);
        Contact contact2 =new Contact(null,"Allan Maia Boehm","30010","1134440472","allan.boehm@polishop.com.br","","Gestão de Resultados",image,true);
        Contact contact3 =new Contact(null,"Alexandre Vieira","30003","1134440676","alexandre.vieira@polishop.com.br","","TI Suporte Interno",image,true);
        Contact contact4 =new Contact(null,"Aline Campos","30009","1134440465","aline.campos@polishop.com.br","","Ecommerce",image,true);
        Contact contact5 =new Contact(null,"Alynne Aparecida Serpa Benedito","30011","1134440555","alynne.benedito@polishop.com.br","","Recursos Humanos",image,true);
        Contact contact6 =new Contact(null,"Ana Abujamra","30088","1134440656","ana.abujamra@polishop.com.br","","Jurídico",image,true);
        Contact contact7 =new Contact(null,"Ana Caroline Cardoso","30012","1134440837","ana.cardoso@polishop.com.br","","Gestão de Resultados",image,true);
        Contact contact8 =new Contact(null,"Ana Ligia Palacio de Morais","30013","1134440557","recepcao@polishop.com.br","","Recepção",image,true);
        Contact contact9 =new Contact(null,"Ana Maia","30014","1134440486","ana.maia@polishop.com.br","","Tesouraria",image,true);
        Contact contact10 =new Contact(null,"Ana Rocha","30038","1134440520","ana.rocha@polishop.com.br","","Marketing",image,true);
        Contact contact11 =new Contact(null,"Anderson Oliveira","30077","","anderson.oliveira@polishop.com.br","","TI Suporte Lojas",image,true);
        Contact contact12 =new Contact(null,"Andrea de Paula","30073","1134440553","andrea.paula@polishop.com.br","","Expansão",image,true);
        Contact contact13 =new Contact(null,"Andresa Franca","30079","1134440631","andresa.franca@polishop.com.br","","Financeiro",image,true);
        Contact contact14 =new Contact(null,"Artur Cogo","30029","1134440516","artur.cogo@polishop.com.br","","Manutenção",image,true);
        Contact contact15 =new Contact(null,"Bernardete Colonic","30034","1134440506","bernardete.colonic@polishop.com.br","","Recursos Humanos",image,true);
        Contact contact16 =new Contact(null,"Bianca Gomes","30061","1134440619","bianca.gomes@polishop.com.br","","Recursos Humanos",image,true);
        Contact contact17 =new Contact(null,"Bruno Santos","30015","1134440745","bruno.santos@polishop.com.br","","TI Suporte Lojas",image,true);
        Contact contact18 =new Contact(null,"Camila Conceição","30016","1134440483","viagens@polishop.com.br","","Tesouraria",image,true);
        Contact contact19 =new Contact(null,"Camila Sanna Cardoso","30017","1134440552","camila.cardoso@polishop.com.br","","Recursos Humanos",image,true);
        Contact contact20 =new Contact(null,"Charllys Araujo","30076","1134440869","charllys.araujo@polishop.com.br","","TI Suporte Interno",image,true);
        Contact contact21 =new Contact(null,"Claudio Faria ","30004","1134440466","claudio.faria@polishop.com.br","","Financeiro",image,true);
        Contact contact22 =new Contact(null,"Daniela Leal","30020","1134440691","daniela.leal@polishop.com.br","","Treinamento",image,true);
        Contact contact23 =new Contact(null,"Dara Oliveira","30021","1134440879","dara.oliveira@polishop.com.br","","Ecommerce",image,true);
        Contact contact24 =new Contact(null,"Denise Oliveira","30022","1134440737","denise.oliveira@polishop.com.br","","Expansão",image,true);
        Contact contact25 =new Contact(null,"Dionisio Bento","30023","1134440618","dionisio.bento@polishop.com.br","","Compras",image,true);
        Contact contact26 =new Contact(null,"Edilson Santos","30024","1134440491","edilson.santos@polishop.com.br","","Contabilidade",image,true);
        Contact contact27 =new Contact(null,"Edson Takaharu Sokabe Junior","30025","","edson.takaharu@polishop.com.br","","Auditoria",image,true);
        Contact contact28 =new Contact(null,"Enfermaria","30089","1134440724","enfermaria@polishop.com.br","","Enfermaria",image,true);
        Contact contact29 =new Contact(null,"Fabiane Ferreira","30026","1134440495","fabiane.ferreira@polishop.com.br","","Comercial",image,true);
        Contact contact30 =new Contact(null,"Fabio Lima","30026","1134440645","fabio.lima@polishop.com.br","","Ecommerce",image,true);
        Contact contact31 =new Contact(null,"Fabio Nogueira","30002","1134440678","fabio.nogueira@polishop.com.br","","TI Suporte Interno",image,true);
        Contact contact32 =new Contact(null,"Fernanda Leite","30085","1134440671","fernanda.leite@polishop.com.br","","Financeiro",image,true);
        Contact contact33 =new Contact(null,"Fernanda Mezvilla","30046","1134440525","fernanda.mezvilla@polishop.com.br","","Compras",image,true);
        Contact contact34 =new Contact(null,"Flavia Guimaraes","30027","1134440773","flavia.guimaraes@polishop.com.br","","Comercial",image,true);
        Contact contact35 =new Contact(null,"Gabriel Silber","30007","1134440490","gabriel.silber@polishop.com.br","","Compras",image,true);
        Contact contact36 =new Contact(null,"Gabriel Wendt","30069","1134440725","gabriel.wendt@polishop.com.br","","Trade Marketing",image,true);
        Contact contact37 =new Contact(null,"Gabriela Batalha","30028","1134440508","gabriela.batalha@polishop.com.br","","Gestão de Resultados",image,true);
        Contact contact38 =new Contact(null,"Gislaine Silva","30084","1134440559","gislaine.silva@polishop.com.br","","Financeiro",image,true);
        Contact contact39 =new Contact(null,"Glaucia Oliveira","30070","1134440581","glaucia.oliveira@polishop.com.br","","Trade Marketing",image,true);
        Contact contact40 =new Contact(null,"Gustavo Almeida","30031","1134440670","gustavo.almeida@polishop.com.br","","TI Suporte Lojas",image,true);
        Contact contact41 =new Contact(null,"Henrique Cugnasca","30032","1134440540","henrique.cugnasca@polishop.com.br","","Financeiro",image,true);
        Contact contact42 =new Contact(null,"Iara Rodrigues Silva","30033","1134440717","iara.silva@polishop.com.br","","Recursos Humanos",image,true);
        Contact contact43 =new Contact(null,"Italo Pires","30034","","italo.pires@polishop.com.br","","Manutenção",image,true);
        Contact contact44 =new Contact(null,"Jefferson Nascimento","30035","1134440518","jefferson.nascimento@polishop.com.br","","Compras",image,true);
        Contact contact45 =new Contact(null,"Jucenor Coelho","30083","1134440560","jucenor.coelho@polishop.com.br","","Financeiro",image,true);
        Contact contact46 =new Contact(null,"Juliana Barbosa","30086","1134440533","juliana.barbosa@polishop.com.br","","Jurídico",image,true);
        Contact contact47 =new Contact(null,"Juliana Farias","30087","1134440639","juliana.farias@polishop.com.br","","Jurídico",image,true);
        Contact contact48 =new Contact(null,"Juliana Felipe","30036","1134440637","juliana.felipe@polishop.com.br","","Marketing",image,true);
        Contact contact49 =new Contact(null,"Juliano Picceli","30037","1134440825","juliano.picceli@polishop.com.br","","TMKT",image,true);
        Contact contact50 =new Contact(null,"Karina Santana","30081","1134440716","karina.santana@polishop.com.br","","Financeiro",image,true);
        Contact contact51 =new Contact(null,"Karine Silva","30091","1134440596","karine.silva@polishop.com.br","","Recursos Humanos",image,true);
        Contact contact52 =new Contact(null,"Lais Freitas","30039","1134440625","lais.freitas@polishop.com.br","","Gestão de Resultados",image,true);
        Contact contact53 =new Contact(null,"Leandro Oliveira","30040","1134440461","leandro.oliveira@polishop.com.br","","Manutenção",image,true);
        Contact contact54 =new Contact(null,"Lennon Yabiku","30080","1134440454","lennon.yabiku@polishop.com.br","","Financeiro",image,true);
        Contact contact55 =new Contact(null,"Leonardo de Oliveira","30092","1134440573","leonardo.deoliveira@polishop.com.br","","Recursos Humanos",image,true);
        Contact contact56 =new Contact(null,"Leonardo Jesus","30041","1134440453","leonardo.jesus@polishop.com.br","","Gestão de Resultados",image,true);
        Contact contact57 =new Contact(null,"Ligia Braga","30042","1134440663","ligia.braga@polishop.com.br","","Comercial",image,true);
        Contact contact58 =new Contact(null,"Livia Camelo","30082","1134440510","livia.camelo@polishop.com.br","","Financeiro",image,true);
        Contact contact59 =new Contact(null,"Luana Strefezza","30044","1134440628","luana.strefezza@polishop.com.br","","Ecommerce",image,true);
        Contact contact60 =new Contact(null,"Lucas Braz","30045","1134440519","lucas.braz@polishop.com.br","","Compliance",image,true);
        Contact contact61 =new Contact(null,"Lucas Santos","30046","","lucas.santos@polishop.com.br","","Compras",image,true);
        Contact contact62 =new Contact(null,"Lucia Ogata","30047","1134440474","lucia.ogata@polishop.com.br","","Comercial",image,true);
        Contact contact63 =new Contact(null,"Luciane Saita","30072","1134440549","luciane.saita@polishop.com.br","","Arquitetura",image,true);
        Contact contact64 =new Contact(null,"Maira Geronimo da Silva","30093","1134440482","maira.silva@polishop.com.br","","Recursos Humanos",image,true);
        Contact contact65 =new Contact(null,"Marcia Faria","30094","1134440574","marcia.faria@polishop.com.br","","Recursos Humanos",image,true);
        Contact contact66 =new Contact(null,"Maria Vieira","30050","1134440514","maria.vieira@polishop.com.br","","Tesouraria",image,true);
        Contact contact67 =new Contact(null,"Marilda Rodrigues Cois","30005","1134440736","m.rodrigues@polishop.com.br","","Tesouraria",image,true);
        Contact contact68 =new Contact(null,"Michelli Higashi","30051","1134440876","michelli.higashi@polishop.com.br","","Comercial",image,true);
        Contact contact69 =new Contact(null,"Michelli Thomé","30052","1134440744","michelli.thome@polishop.com.br","","Comercial",image,true);
        Contact contact70 =new Contact(null,"Niceia Silva","30053","1134440578","niceia.silva@polishop.com.br","","Financeiro",image,true);
        Contact contact71 =new Contact(null,"Paolo Fraga","30068","1134440551","paolo.fraga@polishop.com.br","","Ecommerce",image,true);
        Contact contact72 =new Contact(null,"Patrick Santos Souza","30095","1134440575","patrick.santos@polishop.com.br","","Recursos Humanos",image,true);
        Contact contact73 =new Contact(null,"Paulo Cordeiro","30096","1134440488","paulo.cordeiro@polishop.com.br","","Recursos Humanos",image,true);
        Contact contact74 =new Contact(null,"Rafael Ruiz","30075","1134440759","rafael.ruiz@polishop.com.br","","TI Suporte Lojas",image,true);
        Contact contact75 =new Contact(null,"Renata Gelo","30001","1134440668","renata.gelo@polishop.com.br","","Compras",image,true);
        Contact contact76 =new Contact(null,"Renato Lantin","30056","1134440810","renato.lantin@polishop.com.br","","Comercial",image,true);
        Contact contact77 =new Contact(null,"Renato Rodrigues","30057","1134440542","renato.rodrigues@polishop.com.br","","Ecommerce",image,true);
        Contact contact78 =new Contact(null,"Rita Surita","30074","1134440556","rita.surita@polishop.com.br","","Expansão",image,true);
        Contact contact79 =new Contact(null,"Robson Souza","30090","1134440880","robson.souza@polishop.com.br","","Manutenção",image,true);
        Contact contact80 =new Contact(null,"Rodrigo Peixe","30059","1134440541","rodrigo.peixe@polishop.com.br","","Ecommerce",image,true);
        Contact contact81 =new Contact(null,"Rosana Rosendo","30060","1134440582","rosana.rosendo@polishop.com.br","","Financeiro",image,true);
        Contact contact82 =new Contact(null,"Sabrina Lopes","30071","1134440548","sabrina.lopes@polishop.com.br","","Marketing",image,true);
        Contact contact83 =new Contact(null,"Samuel Junior","30018","1134440692","cetimo.samuel@polishop.com.br","","TMKT",image,true);
        Contact contact84 =new Contact(null,"Sandra Cristiane Gindero","30061","","sandra.gindero@polishop.com.br","","Recursos Humanos",image,true);
        Contact contact85 =new Contact(null,"Sheila Cristina Vilela","30062","1134440547","sheila.vilela@polishop.com.br","","Recrutamento e Seleção",image,true);
        Contact contact86 =new Contact(null,"Simone Rocha","30097","1134440761","simone.rocha@polishop.com.br","","Recursos Humanos",image,true);
        Contact contact87 =new Contact(null,"Thaise Santos","30063","1134440863","thaise.santos@polishop.com.br","","Ecommerce",image,true);
        Contact contact88 =new Contact(null,"Thiago Brandão","30098","1134440617","thiago.brandao@polishop.com.br","","Recursos Humanos",image,true);
        Contact contact89 =new Contact(null,"Thomas Tomas","30043","1134440754","thomas.tomas@polishop.com.br","","TI Suporte Lojas",image,true);
        Contact contact90 =new Contact(null,"Usiel Galvão","30065","1134440545","usiel.galvao@polishop.com.br","","Qualidade",image,true);
        Contact contact91 =new Contact(null,"Wagner Conti","30066","1134440776","wagner.conti@polishop.com.br","","Gestão de Resultados",image,true);
        Contact contact92 =new Contact(null,"Wendell Tavares de Souza","30006","1134440679","wendell.souza@polishop.com.br","","TI Suporte Interno",image,true);
        Contact contact93 =new Contact(null,"Wolas Santos","30099","1134440772","wolas.santos@polishop.com.br","","Recursos Humanos",image,true);

        contactRepository.saveAll(Arrays.asList(contact1 ,
                contact2 ,
                contact3 ,
                contact4 ,
                contact5 ,
                contact6 ,
                contact7 ,
                contact8 ,
                contact9 ,
                contact10 ,
                contact11 ,
                contact12 ,
                contact13 ,
                contact14 ,
                contact15 ,
                contact16 ,
                contact17 ,
                contact18 ,
                contact19 ,
                contact20 ,
                contact21 ,
                contact22 ,
                contact23 ,
                contact24 ,
                contact25 ,
                contact26 ,
                contact27 ,
                contact28 ,
                contact29 ,
                contact30 ,
                contact31 ,
                contact32 ,
                contact33 ,
                contact34 ,
                contact35 ,
                contact36 ,
                contact37 ,
                contact38 ,
                contact39 ,
                contact40 ,
                contact41 ,
                contact42 ,
                contact43 ,
                contact44 ,
                contact45 ,
                contact46 ,
                contact47 ,
                contact48 ,
                contact49 ,
                contact50 ,
                contact51 ,
                contact52 ,
                contact53 ,
                contact54 ,
                contact55 ,
                contact56 ,
                contact57 ,
                contact58 ,
                contact59 ,
                contact60 ,
                contact61 ,
                contact62 ,
                contact63 ,
                contact64 ,
                contact65 ,
                contact66 ,
                contact67 ,
                contact68 ,
                contact69 ,
                contact70 ,
                contact71 ,
                contact72 ,
                contact73 ,
                contact74 ,
                contact75 ,
                contact76 ,
                contact77 ,
                contact78 ,
                contact79 ,
                contact80 ,
                contact81 ,
                contact82 ,
                contact83 ,
                contact84 ,
                contact85 ,
                contact86 ,
                contact87 ,
                contact88 ,
                contact89 ,
                contact90 ,
                contact91 ,
                contact92 ,
                contact93));

         */
    }

}
