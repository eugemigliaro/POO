# frozen_string_literal: true

class Product
    include Comparable

    def initialize(name, price)
        @name = name
        @price = price
    end

    attr_reader :name, :price

    def hash
        [@name, @price].hash
    end

    def to_s
        "#{@name} $#{@price}"
    end

    def <=>(other)
        return nil unless other.is_a? Product
        [@price, @name] <=> [other.price, other.name]
    end
end