# frozen_string_literal: true

class Product

    attr_reader :name
    def initialize(name, price)
        @name = name
        @price = price
    end

    def to_s
        "#{@name} $#{@price}"
    end

    def price
        @price
    end
end
