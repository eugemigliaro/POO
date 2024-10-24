# frozen_string_literal: true

require_relative 'b'
class C < B
    def m_1
        super
    end

    def m_2
        m_2
    end
end
