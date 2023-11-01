package com.quangminh.joinstrategy.visitor;

import com.quangminh.joinstrategy.entity.Ebook;
import com.quangminh.joinstrategy.entity.Paperback;
import org.springframework.stereotype.Component;

@Component
public class BookFixHiperlinksVisitor implements Visitor{
    @Override
    public void visit(Ebook ebook) {
        System.out.println("Applied fixing hiperlinks to ebook '"
                + ebook.getTitle() + "' specific to format " + ebook.getFormat());
    }

    @Override
    public void visit(Paperback paperback) {
        System.out.println("Applied fixing hiperlinks to paperback '"
                + paperback.getTitle() + "' of size " + paperback.getSizeIn());
    }
}
