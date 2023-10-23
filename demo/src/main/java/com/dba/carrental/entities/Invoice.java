package com.dba.carrental.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Entity
@NoArgsConstructor
@Data
@Table(name = "invoices")
public class Invoice {
    @Id
    @GeneratedValue(generator = "invoices")
    @TableGenerator(name = "invoices", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="Invoices",
            initialValue=1, allocationSize=1)

    private long InvoiceId;

    @ManyToOne
    @JoinColumn(name = "CustomerId")
    private Customer customer;
    private String InvoiceDate;
    private String BilingAddress;
    private String BilingCity;
    private String BilingState;
    private String BilingCountry;
    private String BilingPostalCode;
    private Integer  Total;

    @OneToMany(mappedBy = "InvoiceId", fetch = FetchType.LAZY)
    private List<Invoice> invoice;

    public Invoice(long invoiceId, Object Customer, String invoiceDate, String bilingAddress, String bilingCity, String bilingState, String bilingCountry, String bilingPostalCode, Integer total) {
    }
}

