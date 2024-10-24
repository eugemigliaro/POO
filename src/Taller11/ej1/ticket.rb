# frozen_string_literal: true

#Se desea implementar un conjunto de clases que modelen un ticket de venta de un comercio.
# Un ítem consiste en un producto (descripción y precio unitario) y la cantidad de unidades del mismo.
# El total del ticket resulta la suma de los totales de cada uno de sus ítems.
# El ticket cuenta con una numeración autoincremental.
# La impresión de los ítems es por el orden de inserción.
class Ticket
    @@current_id = 0
    def initialize
        @total = 0
        @items = []
        @id = @@current_id
        @@current_id += 1
    end

    def add(product, quantity)
        @items << [product, quantity]
        @total += product.price * quantity
    end

    def to_s
        # TICKET Nº 1000
        # ####################
        # Bayaspirina     2  $99.99
        # Cafiaspirina    1  $79.99
        # ####################
        # TOTAL $279.97

        "TICKET Nº #{@id}\n" + @items.map { |item| "#{item[0].name} #{item[1]} $#{item[0].price}" }.join("\n") + "\nTOTAL $#{format('%.2f', @total)}"
    end
end
