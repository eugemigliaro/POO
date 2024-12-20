# frozen_string_literal: true

# Ahora se desea restringir que se agreguen productos equivalentes en invocaciones distintas.
# Para el siguiente programa de prueba:

# third_ticket = Ticket.new
# third_ticket.add(aspirinetas, 1)
# third_ticket.add(Product.new('Aspirinetas', 49.99), 1)
# puts third_ticket

# Se debe obtener la siguiente salida:
# TICKET Nº 1002
# ####################
# Aspirinetas    	1	$49.99
# ####################
# TOTAL $49.99

#hay que usar un set de items para el ticket

require_relative 'item'
require_relative 'product'
class Ticket
    @@current_id = 0

    def initialize
        @id = @@current_id
        @@current_id += 1
        @items = Set.new
        @total = 0
    end

    def add(product, quantity)
        new = Item.new(product, quantity)
        if @items.add?(new)
            @total += product.price * quantity
        end
    end

    def to_s
        "TICKET Nº #{@id}\n" + @items.sort.map { |item| "#{item}" }.join("\n") + "\nTOTAL $#{format('%.2f', @total)}"
    end
end
