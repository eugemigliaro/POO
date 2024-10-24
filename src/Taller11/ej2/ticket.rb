# frozen_string_literal: true

#Ahora se desea permitir que se agreguen productos equivalentes en invocaciones distintas.
# Para el siguiente programa de prueba:
# third_ticket = Ticket.new
# third_ticket.add(aspirinetas, 1)
# third_ticket.add(Product.new('Aspirinetas', 49.99), 1)
# puts third_ticket

#Se debe obtener la siguiente salida:
# TICKET Nº 1002
# ####################
# Aspirinetas    	2	$49.99
# ####################
# TOTAL $99.98
class Ticket
    @@current_id = 0

    def initialize
        @id = @@current_id
        @@current_id += 1
        @items = []
        @total = 0
    end

    def add(product, quantity)
        if (aux = @items.find { |item| item[0] == product })
            aux[1] += quantity
        else
            @items << [product, quantity]
        end
        @total += product.price * quantity
    end

    def to_s
        "TICKET Nº #{@id}\n" + @items.map { |item| "#{item[0].name} #{item[1]} $#{item[0].price}" }.join("\n") + "\nTOTAL $#{format('%.2f', @total)}"
    end
end
