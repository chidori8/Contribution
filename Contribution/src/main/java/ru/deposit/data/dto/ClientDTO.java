package ru.deposit.data.dto;

import lombok.Data;
import ru.deposit.data.enumurate.OrganizationalForm;


@Data
public class ClientDTO {

    private String name;
    private String shortName;
    private OrganizationalForm organizationalForm;
}
