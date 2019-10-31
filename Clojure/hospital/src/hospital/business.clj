(ns hospital.business)

(defn full?
  [hospital sector]
  (-> hospital
      (get sector)
      count
      (< 5))


  queue (get hospital sector)
  current-length (count queue)
  fit? (< current-lenght 5))

(def arrive-at
  [hospital sector person]
    (if (full? hospital sector )
      (throw (ex-info "Queue is already full" {:try-add person}))
      (update hospital sector conj person)))

(def call
  [hospital sector]
  (update hospital sector pop))




