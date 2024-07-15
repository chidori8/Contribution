package ru.deposit.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.TypeDef;
import ru.deposit.data.enumurate.OrganizationalForm;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "client_id_seq")
    @SequenceGenerator(name = "client_id_seq", sequenceName = "client_id_seq", allocationSize = 1)
    private Long id;

    private String name;

    private String short_name;

    @Enumerated(EnumType.STRING)
    @ColumnTransformer(write = "?::organizational_form")
    private OrganizationalForm curr_organizational_form;

}
