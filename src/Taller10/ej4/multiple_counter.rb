# frozen_string_literal: true

require_relative 'counter'
class MultipleCounter < Counter
    def initialize(delta)
        super()
        @delta = delta
    end
    def increment
        aux = @delta
        while aux > 0
            super
            aux -= 1
        end
    end
    def decrement
        aux = @delta
        while aux > 0
            super
            aux -= 1
        end
    end
end
