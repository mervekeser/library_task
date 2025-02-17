package com.mervekeser.library.domain.dtos.book;

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
public class UpdateBookRequest {
    private String title;
    private BigDecimal price;
    private String isbn13;
    private Integer editionYear;
    private UUID publisherId;

    @Builder.Default
    private Set<UUID> authorIds = new HashSet<>();
}
