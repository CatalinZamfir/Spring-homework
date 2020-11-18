package org.example.config;

import org.example.entity.Invoices;
import org.example.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {
        @Autowired
        public Repository repository;

        public Invoices saveInvoice (Invoices invoice){
            return repository.save(invoice);
        }

        public List<Invoices> getInvoices(){
            return repository.findAll();
        }

        public Optional<Invoices> findById (int id){
        return repository.findById(id);
        }

        public String deleteById (int id){
        repository.deleteById(id);
        return "invoice removed " + id;
    }

    public Invoices updateInvoice (Invoices invoice){
        Invoices existingInvoice = repository.findById(invoice.getId()).orElse(null);
                existingInvoice.setCompany(invoice.getCompany());
                existingInvoice.setDescription(invoice.getDescription());
                existingInvoice.setPrice(invoice.getPrice());
                return repository.save(existingInvoice);
    }

}
