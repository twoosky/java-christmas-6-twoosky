package christmas.dto;

import java.util.Map;

public record GiftsDto(
        Map<String, Integer> gifts
) {}
