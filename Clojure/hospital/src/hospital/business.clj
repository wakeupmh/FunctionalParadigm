
(ns hospital.business)

(def arrive-at
  [hospital sector person]
  (update hospital sector conj person))

(def call
  [hospital sector]
  (update hospital sector pop))