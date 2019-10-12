(ns labs.prediction-bindings-when)
;handling cyclomatic complexity

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

;Function as param (all function is a symbol)
(println (discounted-value expensive-than-100? 1000))
;HOF (High Order Function)
;Binding (function calls function) is executed in run time
;When statement is used for a if without else

;Function without name (Anonymous Function or Lambda Function), short but complex:
(fn [value] (> value 100))
(println (discounted-value (fn [value] (> value 100)) 1000))

(fn [v] (> v 100))
(println (discounted-value (fn [v] (> v 100)) 1000))

#(> v 100)
(println (discounted-value #(> v 100) 1000))

#(> %1 100)
(println (discounted-value #(> %1 100) 1000))

#(> % 100)
(println (discounted-value #(> % 100) 1000))

(def expensive-than-100? #(> % 100))  ;that is a symbol who represents a function isn't a func properly

;# -> represents a fn (anom func)