package com.vich.farm_management.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.vich.farm_management.model.AppUser;
import com.vich.farm_management.repository.UserRepository;

/**
 * Initialization data for testing using CommandLineRunner
 */
@Component
public class InitData implements CommandLineRunner {

    @Autowired
    private UserRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        
        if (usuarioRepository.count() == 0) {
            
            AppUser admin = new AppUser();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin123")); 

            usuarioRepository.save(admin);
            
            System.out.println("---------------------------------");
            System.out.println(" USUARIO ADMIN CREADO");
            System.out.println(" Usuario: admin");
            System.out.println(" Clave: admin123");
            System.out.println("---------------------------------");

            // AppUser user = usuarioRepository.findByUsername("admin")
            //         .orElseThrow(() -> new RuntimeException("No se pudo obtener el usuario"));

            // System.out.println(user.getUsername() + " - " + user.getPassword());
        } else {
            System.out.println("La base de datos ya tiene usuarios, saltando creación inicial.");
        }
    }
}
