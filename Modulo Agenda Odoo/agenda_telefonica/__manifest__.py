{
    'name': 'Agenda Telefónica',
    'version': '1.0',
    'author': 'David',
    'category': 'Productivity',
    'summary': 'Gestión de contactos telefónicos',
    'description': """
        Módulo para gestionar una agenda telefónica con nombre y teléfono.
    """,
    'depends': ['base'],
    'data': [
        'security/ir.model.access.csv',
        'views/agenda_view.xml',
    ],
    'installable': True,
    'application': True,
}