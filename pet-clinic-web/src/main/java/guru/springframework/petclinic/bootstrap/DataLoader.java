package guru.springframework.petclinic.bootstrap;

import guru.springframework.petclinic.model.Owner;
import guru.springframework.petclinic.model.Vet;
import guru.springframework.petclinic.services.OwnerService;
import guru.springframework.petclinic.services.VetService;
import guru.springframework.petclinic.services.map.OwnerServiceMap;
import guru.springframework.petclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("fname1");
        owner1.setLastName("lname1");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("fname2");
        owner2.setLastName("lname2");
        ownerService.save(owner2);

        System.out.println("LOADED OWNERS...");

        Vet vet1 = new Vet();
        vet1.setFirstName("vetFname1");
        vet1.setLastName("vetLname1");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("vetFname2");
        vet2.setLastName("vetLname2");
        vetService.save(vet2);

        System.out.println("LOADED VETS...");
    }
}
