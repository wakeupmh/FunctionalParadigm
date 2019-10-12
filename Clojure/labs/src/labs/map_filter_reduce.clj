(ns labs.map-filter-reduce)

(def prices [30 700 1000 400 900])

(defn expensive-than-100?
  [value]
  (> value 100))

(defn discounted-value
  [value]
  (if (expensive-than-100? value)
    (let [discount-tax (/ 15 100)
          discount (* value discount-tax)]
      (- value discount))
    value))
;MAP
(println (map discounted-value prices))

;FILTER
(println (range 10))
(println (filter odd? (range 10)))
(println (filter even? (range 10)))

(println (filter expensive-than-100? prices))

;MAP AND FILTER
(println (map discounted-value (filter expensive-than-100? prices)))

;REDUCE
(println (reduce + prices))

(defn sum
  [value-1 value-2]
  (+ value-1 value-2))

(println (reduce sum prices))

(println (reduce sum  15 prices))                           ;initialize the sum with 15