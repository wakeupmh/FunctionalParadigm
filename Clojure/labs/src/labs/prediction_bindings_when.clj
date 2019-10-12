(ns labs.prediction-bindings-when)
;Predicate
(defn apply-discount?
  [value]
  (> value 100))

(defn discounted-value
  [value]
  (if (apply-discount? value)
    (let [discount-tax (/ 15 100)
          discount (* value discount-tax)]
      (- value discount))
    value))

(println (apply-discount? 1000))
(println (discounted-value 1000))

;Binding is executed in run time
;When statement is used for a if without else