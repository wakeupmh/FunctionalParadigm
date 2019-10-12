(ns labs.prediction-bindings-when)
;Predicate
(defn expensive-than-100?
  [value]
  (> value 100))

(defn discounted-value
  [expensive-than-100? value]
  (if (expensive-than-100? value)
    (let [discount-tax (/ 15 100)
          discount (* value discount-tax)]
      (- value discount))
    value))

(println (discounted-value expensive-than-100? 1000))

;Binding (function calls function) is executed in run time
;When statement is used for a if without else