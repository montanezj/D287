package com.example.demo.bootstrap;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if(outsourcedPartRepository.count() == 0) {

            OutsourcedPart CPU = new OutsourcedPart();
            CPU.setName("CPU");
            CPU.setInv(300);
            CPU.setId(300);
            CPU.setPrice(520.00);
            CPU.setCompanyName("Western Governors University");
            outsourcedPartRepository.save(CPU);

            OutsourcedPart GPU = new OutsourcedPart();
            GPU.setName("GPU");
            GPU.setInv(300);
            GPU.setId(456);
            GPU.setPrice(780.89);
            GPU.setCompanyName("Western Governors University");
            outsourcedPartRepository.save(GPU);

            OutsourcedPart Motherboard = new OutsourcedPart();
            Motherboard.setName("Motherboard");
            Motherboard.setInv(300);
            Motherboard.setId(55000);
            Motherboard.setPrice(250.33);
            Motherboard.setCompanyName("Western Governors University");
            outsourcedPartRepository.save(Motherboard);

            OutsourcedPart Memory = new OutsourcedPart();
            Memory.setName("Memory");
            Memory.setInv(750);
            Memory.setPrice(120.00);
            Memory.setId(399);
            Memory.setCompanyName("Western Governors University");
            outsourcedPartRepository.save(Memory);

            OutsourcedPart PSU = new OutsourcedPart();
            PSU.setName("PSU");
            PSU.setInv(300);
            PSU.setPrice(185.09);
            PSU.setId(400);
            PSU.setCompanyName("Western Governors University");
            outsourcedPartRepository.save(PSU);

        }
       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */
            List<OutsourcedPart> outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for (OutsourcedPart part : outsourcedParts) {
                System.out.println(part.getName() + " " + part.getCompanyName());
            }

            if(productRepository.count() == 0) {
                Product GamingPC = new Product(1200, "GamingPC", 100.0, 15);
                Product LowEndPC = new Product(1212, "LowEndPC", 100.0, 15);
                Product HighEndPC = new Product(1515, "HighEndPC", 100.0, 15);
                Product StreamingPC = new Product(1616, "StreamingPC", 100.0, 15);
                Product MacBook = new Product(1717, "MacBook", 100.0, 15);

                productRepository.save(GamingPC);
                productRepository.save(LowEndPC);
                productRepository.save(HighEndPC);
                productRepository.save(StreamingPC);
                productRepository.save(MacBook);

                System.out.println("Started in Bootstrap");
                System.out.println("Number of Products" + productRepository.count());
                System.out.println(productRepository.findAll());
                System.out.println("Number of Parts" + partRepository.count());
                System.out.println(partRepository.findAll());
            }

    }
}
