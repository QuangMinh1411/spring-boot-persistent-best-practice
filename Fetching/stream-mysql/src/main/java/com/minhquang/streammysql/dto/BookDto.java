package com.minhquang.streammysql.dto;

/**
 * Projection for {@link com.minhquang.streammysql.entity.Book}
 */
public class BookDto {
    private final int price;
    private final String title;

    public BookDto(int price, String title) {
        this.price = price;
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "BookDto{" + "price=" + price + ", title=" + title + '}';
    }
}