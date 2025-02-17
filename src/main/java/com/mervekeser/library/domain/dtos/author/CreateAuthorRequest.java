package com.mervekeser.library.domain.dtos.author;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record CreateAuthorRequest(
        @NotBlank(message = "Author fullname is required")
        @Size(min = 2, max = 50, message = "Author fullname must be between {min} and {max} characters")
        @Pattern(regexp = "^[\\w\\s-]+$", message = "Author fullname can only contain letters, numbers, spaces, and hyphens")
        String fullname
) {
}
