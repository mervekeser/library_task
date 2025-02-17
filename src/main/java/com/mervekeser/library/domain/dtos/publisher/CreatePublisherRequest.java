package com.mervekeser.library.domain.dtos.publisher;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatePublisherRequest{
        @NotBlank(message = "Publisher name is required")
        @Size(min = 2, max = 50, message = "Publisher name must be between {min} and {max} characters")
        @Pattern(regexp = "^[\\w\\s-]+$", message = "Publisher name can only contain letters, numbers, spaces, and hyphens")
       private String name;

}
