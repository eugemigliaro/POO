# frozen_string_literal: true

class Product
    def initialize(name, price)
        @name = name
        @price = price
    end

    attr_reader :name, :price

    def ==(other)
        name == other.name && price == other.price
    end

    def hash
        [name, price].hash
    end

    def to_s
        "#{@name} $#{@price}"
    end
end
