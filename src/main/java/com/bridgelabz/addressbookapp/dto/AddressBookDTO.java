package com.bridgelabz.addressbookapp.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class AddressBookDTO {

    @NotBlank(message = "Name should not be empty")
    @Pattern(regexp = "^[A-Za-z ]{2,}$", message = "Name must contain only alphabets and min 2 characters")
    private String name;

    private String city;
}