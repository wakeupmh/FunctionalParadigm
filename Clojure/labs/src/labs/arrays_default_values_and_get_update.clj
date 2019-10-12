(ns labs.arrays-default-values-and-get-update)

(def prices [30 70 1000])

;GET -> handle error, if is indexOutOfBounds returns for me a nil instead of a Exception
(println (prices 0))
(println (get prices 30))
(println (prices 17))                                       ;throw an exception (indexOutOfBounds)
(println (get prices 17))                                   ;returns nil
(println (get prices 17 0))                                 ;if value doesn't exist returns a default val instead of nil

(println (conj prices 5))                                   ;creates a ref (new array) with a new value 5, prices is immutable

;UPDATE -> extract a value execute a func and return a new array with update value, remember array is immutable
(println (+ 5 1))
(println (inc 5))
(println (update prices 0 inc))
(println (update prices 1 inc))

(defn sum-1
  [value]
  (inc value))

(println (update prices 0 sum-1))



