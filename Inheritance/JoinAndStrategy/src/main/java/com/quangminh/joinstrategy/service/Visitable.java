package com.quangminh.joinstrategy.service;

import com.quangminh.joinstrategy.visitor.Visitor;

public interface Visitable {
    void accept(Class<? extends Visitor> clazzVisitor);
}
