package com.mervekeser.library.domain.dtos.publisher;

import com.mervekeser.library.domain.dtos.book.BookDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PublisherDto{
       private String name;

}
