package br.com.diogo.policyapi.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Policy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String insuredName;
    private double premiumValue;
    private String category;

    public Policy(String insuredName, double premiumValue, String category){
        this.insuredName = insuredName;
        this.premiumValue = premiumValue;
        this.category = category;
    }

    public Policy() {
    }

    public String getInsuredName() { return insuredName; }
    public double getPremiumValue() { return premiumValue; }
    public String getCategory() { return category; }
    public Long getId() { return id; }
}
