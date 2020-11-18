package org.example.controller;

import org.example.config.InvoiceService;
import org.example.entity.Invoices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RestControllers {

    @Autowired
    public InvoiceService invoiceService;


    @PostMapping("/addInvoice")
    public Invoices addInvoice (@RequestBody Invoices invoice){
        return invoiceService.saveInvoice(invoice);
    }
    
    @GetMapping("/getInvoiceById/{id}")
    public Optional<Invoices> getInvoiceById (@PathVariable int id){
        return invoiceService.findById(id);
    }
    @GetMapping ("/getInvoices")
    public List<Invoices> getInvoices(){
        return invoiceService.getInvoices();
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteById (@PathVariable int id){
        return invoiceService.deleteById(id);
    }

    @PutMapping ("/update")
    public Invoices updateInvoice (@RequestBody Invoices invoice){
        return invoiceService.updateInvoice(invoice);
    }

}
