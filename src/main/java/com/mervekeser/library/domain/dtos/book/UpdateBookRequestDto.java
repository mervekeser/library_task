package com.mervekeser.library.domain.dtos.book;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateBookRequestDto {
    @NotNull(message = "Title is required")
    private String title;

    @NotNull(message = "Price is required")
    private BigDecimal price;

    @NotNull(message = "Isbn13 is required")
    private String isbn13;

    @NotNull(message = "Edition year is required")
    @Positive(message = "Edition year must be greater than zero")
    private Integer editionYear;

    @NotNull(message = "Publisher ID is required")
    private UUID publisherId;

    @Builder.Default
    @Size(max = 10, message = "Maximum {max} authors allowed")
    private Set<UUID> authorIds = new HashSet<>();
}
