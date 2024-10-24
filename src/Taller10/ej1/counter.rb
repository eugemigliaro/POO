# frozen_string_literal: true

class Counter
    attr_reader :count
    def initialize
        @count = 0
    end

    def increment
        @count += 1
    end

    def decrement
        @count -= 1
    end

    def count=(value)
        @count = value
    end

    def to_s
        "#{@count}"
    end
end
