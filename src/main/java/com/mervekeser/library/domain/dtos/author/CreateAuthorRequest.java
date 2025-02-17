package com.mervekeser.library.domain.dtos.author;

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
public class CreateAuthorRequest{
        @NotBlank(message = "Author fullname is required")
        @Size(min = 2, max = 50, message = "Author fullname must be between {min} and {max} characters")
        @Pattern(regexp = "^[\\w\\s-]+$", message = "Author fullname can only contain letters, numbers, spaces, and hyphens")
        private String fullname;

}
