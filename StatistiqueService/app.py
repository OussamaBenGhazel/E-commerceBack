from flask import Flask, jsonify

app = Flask(__name__)

# Exemple de statistiques
@app.route('/statistiques/commandes', methods=['GET'])
def get_stats():
    stats = {
        "nombre_total_commandes": 120,
        "moyenne_par_client": 3.5,
        "commande_max": 1000.00,
        "commande_min": 5.25
    }
    return jsonify(stats)

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5001)
