package com.mervekeser.library.domain.dtos.publisher;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record CreatePublisherRequest(
        @NotBlank(message = "Publisher name is required")
        @Size(min = 2, max = 50, message = "Publisher name must be between {min} and {max} characters")
        @Pattern(regexp = "^[\\w\\s-]+$", message = "Publisher name can only contain letters, numbers, spaces, and hyphens")
        String name
) {
}
