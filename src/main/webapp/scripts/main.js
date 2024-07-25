document.getElementById('scenario-form').addEventListener('submit', function(e) {
    e.preventDefault();

    const title = document.getElementById('title').value;
    const description = document.getElementById('description').value;
    const materials = document.getElementById('materials').value;
    const steps = document.getElementById('steps').value;

    const scenarioList = document.getElementById('scenario-list');

    const scenarioItem = document.createElement('div');
    scenarioItem.classList.add('scenario-item');

    scenarioItem.innerHTML = `
        <h3>${title}</h3>
        <p><strong>Description:</strong> ${description}</p>
        <p><strong>Materials:</strong> ${materials}</p>
        <p><strong>Steps:</strong> ${steps}</p>
    `;

    scenarioList.appendChild(scenarioItem);

    document.getElementById('scenario-form').reset();
});