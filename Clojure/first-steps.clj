(defn value-discounted 
    "Function to apply 15% discount in a value"
    [value]
    (let [discount-tax (/ 15 100)
        discount (* value discount-tax)]
        (* value (- value discount))))

(value-discounted 1000)


(defn exp [x n]
  (reduce * (repeat n x)))

(exp 2 3)