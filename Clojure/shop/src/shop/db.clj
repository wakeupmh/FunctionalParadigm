(ns shop.db)

(def demand {:user 15
             :itens {:bag {:id :bag :quantity 3 :price 80}
                     :t-shirt {:id :t-shirt :quantity 3 :price 40}
                     :shoes {:id :shoes :quantity 3}}})
(def demand2 {:user 15
             :itens {:bag {:id :bag :quantity 3 :price 80}
                     :t-shirt {:id :t-shirt :quantity 3 :price 40}
                     :shoes {:id :shoes :quantity 3}}})
(def demand3 {:user 15
             :itens {:bag {:id :bag :quantity 3 :price 80}
                     :t-shirt {:id :t-shirt :quantity 3 :price 40}
                     :shoes {:id :shoes :quantity 3}}})
(def demand4 {:user 11
             :itens {:bag {:id :bag :quantity 2 :price 80}
                     :t-shirt {:id :t-shirt :quantity 3 :price 40}
                     :shoes {:id :shoes :quantity 7}}})

(def demand5 {:user 11
              :itens {:bag {:id :bag :quantity 5 :price 80}
                      :t-shirt {:id :t-shirt :quantity 3 :price 40}
                      :shoes {:id :shoes :quantity 30}}})

(defn all-demands []
  [demand, demand2, demand3, demand4, demand5])