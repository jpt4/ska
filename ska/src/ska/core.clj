(ns ska.core)

(defn solovay-kitaev [u n]
  (if (= n 0)
    (basic-approximation u)
    (let [un-1 (solovay-kitaev u (- n 1))
          v (gc-decompose (gate-op u (gate-inverse un-1)))
          w v
          vn-1 (solovay-kitaev v (- n 1))
          wn-1 (solovay-kitaev w (- n 1))
          vn-1-inv (gate-inverse vn-1)
          wn-1-inv (gate-inverse vn-1)]
      (reduce gate-op (reverse (list vn-1 wn-1 vn-1-inv wn-1-inv un-1))))))


;prematurely optimizing for stack overflow
(comment 
(defn solovay-kitaev-optimized




  "Optimized Solovay-Kitaev algorithm."
  [u n]
  
  (if (= n 0)
    (basic-approximation u)
    (recur (solovay-kitaev u (- n 1)))))
)

