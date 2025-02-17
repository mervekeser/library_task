package com.mervekeser.library.domain.dtos.book;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mervekeser.library.domain.dtos.author.AuthorDto;
import com.mervekeser.library.domain.dtos.publisher.PublisherDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDto{
       private String title;
       private BigDecimal price;
       private String isbn13;
       private Integer editionYear;
       private PublisherDto publisherDto;
       private Set<AuthorDto> authors;

}
