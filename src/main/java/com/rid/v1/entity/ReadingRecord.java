package com.rid.v1.entity;

public record ReadingRecord(int id,String readingType,
                            double readingValue,String readingDate,
                            String description,String time) {
}
