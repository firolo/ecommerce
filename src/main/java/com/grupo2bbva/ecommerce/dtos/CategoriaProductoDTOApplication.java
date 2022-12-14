package com.grupo2bbva.ecommerce.dtos;

public class CategoriaProductoDTOApplication {
    private Long idproduct;
    private Long idcategory;

    public Long getIdproduct() {
        return idproduct;
    }

    public Long getIdcategory() {
        return idcategory;
    }

    public CategoriaProductoDTOApplication() {}

    public CategoriaProductoDTOApplication(Long idproduct, Long idcategory) {
        this.idproduct = idproduct;
        this.idcategory = idcategory;
    }
}
