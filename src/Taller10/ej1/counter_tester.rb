# frozen_string_literal: true

require_relative 'counter'

my_counter = Counter.new
puts my_counter.count # Imprime 0
puts my_counter.increment # Aumenta en 1
my_counter.increment
puts my_counter.count # Imprime 2
my_counter.decrement # Disminuye en 1
puts my_counter.count # Imprime 1

my_counter.count = 10 # Setea el contador
my_counter.increment
puts my_counter.count # Imprime 11

puts my_counter # Imprime 11

