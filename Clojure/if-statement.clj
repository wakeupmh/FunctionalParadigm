
(defn value-discounted 
    "Function to apply 15% discount in a value if value is greater than 100"
    [value]
    (if (> value 100)
        (let [discount-tax (/ 15 100)
            discount (* value discount-tax)]
            (- value discount))
        value))
