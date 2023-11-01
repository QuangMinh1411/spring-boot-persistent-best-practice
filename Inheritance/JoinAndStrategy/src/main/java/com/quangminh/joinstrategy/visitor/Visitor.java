package com.quangminh.joinstrategy.visitor;

import com.quangminh.joinstrategy.entity.Ebook;
import com.quangminh.joinstrategy.entity.Paperback;

public interface Visitor {
    void visit(Ebook ebook);

    void visit(Paperback paperback);
}
