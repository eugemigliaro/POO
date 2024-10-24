# frozen_string_literal: true

class Item
    attr_reader :product, :quantity

    def initialize(product, quantity)
        @product = product
        @quantity = quantity
    end

    def ==(other)
        product == other.product
    end

    def to_s
        "#{@product.name} #{@quantity} #{@product.price}"
    end

    def hash
        product.hash
    end

    alias eql? ==
end
