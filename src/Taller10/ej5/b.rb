# frozen_string_literal: true

require_relative 'a'
class B < A
    def m_1
        super
    end

    def m_2
        super.m_1
    end

    def m_3
        4
    end
end