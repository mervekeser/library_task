package com.mervekeser.library.domain.dtos.author;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mervekeser.library.domain.dtos.book.BookDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorDto{
       private String fullname;

}
